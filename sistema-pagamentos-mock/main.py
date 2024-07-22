# main_app.py
import requests
import os
import psycopg2
from flask import Flask, request, jsonify

app = Flask(__name__)


def get_db_connection():
    return psycopg2.connect(
        dbname=os.environ['POSTGRES_DB'],
        user=os.environ['POSTGRES_USER'],
        password=os.environ['POSTGRES_PASSWORD'],
        host='db'
    )


@app.route('/pagamento/<id_pedido>', methods=['POST'])
def efetuar_pagamento(id_pedido):
    status_pagamento = "aprovado" if int(id_pedido) % 2 == 0 else "reprovado"

    # Conectar ao banco de dados e inserir os dados
    conn = get_db_connection()
    cur = conn.cursor()
    cur.execute(
        "INSERT INTO pagamento (id_pedido, status) VALUES (%s, %s) "
        "ON CONFLICT (id_pedido) DO UPDATE SET status = EXCLUDED.status",
        (id_pedido, status_pagamento)
    )
    conn.commit()
    cur.close()
    conn.close()

    return jsonify({
        "id_pedido": id_pedido,
        "status": status_pagamento
    })


def consultar_pagamento(id_pedido):
    url = f"http://127.0.0.1:5001/status_pagamento/{id_pedido}"
    response = requests.get(url)

    print(f"Consulta do status do pagamento. Status Code: {response.status_code}, Response: {response.json()}")


if __name__ == '__main__':
    app.run(port=5001, debug=True)
