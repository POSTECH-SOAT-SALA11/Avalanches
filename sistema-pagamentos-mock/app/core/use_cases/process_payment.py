class ProcessPayment:
    @staticmethod
    def execute(id_pedido):
        return "APROVADO" if int(id_pedido) % 2 == 0 else "REPROVADO"
