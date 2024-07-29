from flask import Flask
from app.api.payment_controller import payment_bp

app = Flask(__name__)
app.register_blueprint(payment_bp)

if __name__ == '__main__':
    app.run(port=5001, debug=True)
