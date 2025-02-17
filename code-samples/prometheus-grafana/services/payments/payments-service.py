from flask import Flask, jsonify
from opentelemetry import trace
from opentelemetry.sdk.trace import TracerProvider
from opentelemetry.sdk.trace.export import BatchSpanProcessor
from opentelemetry.exporter.otlp.proto.grpc.trace_exporter import OTLPSpanExporter
from opentelemetry.instrumentation.flask import FlaskInstrumentor
from opentelemetry.instrumentation.requests import RequestsInstrumentor
import requests
import signal
import sys
# from tracing import init_tracer

def sigterm_handler(signum, frame):
    sys.exit(0)

signal.signal(signal.SIGTERM, sigterm_handler)

def init_tracer(service_name):
    trace.set_tracer_provider(TracerProvider())
    otlp_exporter = OTLPSpanExporter(endpoint="http://jaeger:4317")
    span_processor = BatchSpanProcessor(otlp_exporter)
    trace.get_tracer_provider().add_span_processor(span_processor)
    
    # Initialize instrumentors
    RequestsInstrumentor().instrument()
    return trace.get_tracer(service_name)

tracer = init_tracer("payments-service")
app = Flask(__name__)
FlaskInstrumentor().instrument_app(app)

@app.route("/")
def create_order():
    print("handling request")
    response = requests.get("http://customer-service/")
    return jsonify({"order_created": True})

if __name__ == "__main__":
    app.run(host="0.0.0.0", port=80)