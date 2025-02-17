from flask import Flask, jsonify
import requests
import signal
import sys
# from tracing import init_tracer

def sigterm_handler(signum, frame):
    sys.exit(0)

signal.signal(signal.SIGTERM, sigterm_handler)

app = Flask(__name__)
# tracer = init_tracer("service1")
# FlaskInstrumentor().instrument_app(app)

@app.route("/")
def create_order():
    print("handling request")
    requests.get("http://inventory-service/")
    requests.get("http://payments-service/")
    requests.get("http://compliance-service/")
    return jsonify({"order_created": True})

if __name__ == "__main__":
    app.run(host="0.0.0.0", port=80)