# main_app.py
import requests
import uuid
import json

from flask import Flask, request, jsonify

app = Flask(__name__)


@app.route('/pagamento/<id_pedido>', methods=['GET'])
def efetuar_pagamento(id_pedido):
    status_pagamento = "aprovado" if int(id_pedido) % 2 == 0 else "reprovado"

    return {
        "id_pedido": id_pedido,
        "status": status_pagamento
    }


def consultar_pagamento(id_pedido):
    url = f"http://127.0.0.1:5001/status_pagamento/{id_pedido}"
    response = requests.get(url)

    print(f"Consulta do status do pagamento. Status Code: {response.status_code}, Response: {response.json()}")


if __name__ == '__main__':
    app.run(port=5001, debug=True)
