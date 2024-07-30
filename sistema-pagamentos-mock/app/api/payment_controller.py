from flask import Blueprint, request, jsonify
from app.core.use_cases.process_payment import ProcessPayment
from app.infrastructure.db.payment_repository import PaymentRepository
from app.infrastructure.web.payment_service import PaymentService
import requests

payment_bp = Blueprint('payment', __name__)

@payment_bp.route('/pagamento/<id_pedido>', methods=['POST'])
def efetuar_pagamento(id_pedido):
    status_pagamento = PaymentService().process_payment(id_pedido)

    # Dados para o webhook
    webhook_data = {
        "idPedido": id_pedido,
        "status": status_pagamento
    }

    # URL do webhook
    webhook_url = 'http://localhost:8080/avalanches/v1/pagamento/webhook'

    # Enviar requisição POST para o webhook
    try:
        response = requests.post(webhook_url, json=webhook_data, headers={'Content-Type': 'application/json'})
        response.raise_for_status()  # Levanta um erro para códigos de status 4xx/5xx
        print(f"Webhook acionado com sucesso: {response.status_code}")
    except requests.exceptions.RequestException as e:
        print(f"Erro ao acionar o webhook: {e}")

    return jsonify({"id_pedido": id_pedido, "status": status_pagamento})
