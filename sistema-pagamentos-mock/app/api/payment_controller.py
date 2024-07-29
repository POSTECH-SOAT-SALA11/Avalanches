from flask import Blueprint, request, jsonify
from app.core.use_cases.process_payment import ProcessPayment
from app.infrastructure.db.payment_repository import PaymentRepository
from app.infrastructure.web.payment_service import PaymentService

payment_bp = Blueprint('payment', __name__)

@payment_bp.route('/pagamento/<id_pedido>', methods=['POST'])
def efetuar_pagamento(id_pedido):
    status_pagamento = PaymentService().process_payment(id_pedido)
    repository = PaymentRepository()
    repository.save_payment(id_pedido, status_pagamento)
    return jsonify({"id_pedido": id_pedido, "status": status_pagamento})
