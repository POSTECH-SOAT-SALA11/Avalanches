import os
import psycopg2

class PaymentRepository:
    def __init__(self):
        self.conn = psycopg2.connect(
            dbname=os.environ['POSTGRES_DB'],
            user=os.environ['POSTGRES_USER'],
            password=os.environ['POSTGRES_PASSWORD'],
            host=os.environ['POSTGRES_HOST']
        )

    def save_payment(self, id_pedido, status_pagamento):
        cur = self.conn.cursor()
        cur.execute(
            "INSERT INTO pagamento (id_pedido, status) VALUES (%s, %s) "
            "ON CONFLICT (id_pedido) DO UPDATE SET status = EXCLUDED.status",
            (id_pedido, status_pagamento)
        )
        self.conn.commit()
        cur.close()
        self.conn.close()
