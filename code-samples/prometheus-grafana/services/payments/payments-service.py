from flask import Flask, jsonify
from opentelemetry import trace
from opentelemetry.sdk.trace import TracerProvider
from opentelemetry.sdk.trace.export import BatchSpanProcessor
from opentelemetry.exporter.otlp.proto.grpc.trace_exporter import OTLPSpanExporter
from opentelemetry.instrumentation.flask import FlaskInstrumentor
from opentelemetry.instrumentation.requests import RequestsInstrumentor
from opentelemetry.sdk.resources import Resource
import requests
import signal
import sys

# Configure shutdown handler
def sigterm_handler(signum, frame):
    sys.exit(0)

signal.signal(signal.SIGTERM, sigterm_handler)

# Init Flask App
app = Flask(__name__)

# Initialize instrumentors
resource = Resource.create({"service.name": "payments-service"})
trace.set_tracer_provider(TracerProvider(resource=resource))
otlp_exporter = OTLPSpanExporter(endpoint="http://jaeger:4317")
span_processor = BatchSpanProcessor(otlp_exporter)
trace.get_tracer_provider().add_span_processor(span_processor)
RequestsInstrumentor().instrument()
FlaskInstrumentor().instrument_app(app)
tracer = trace.get_tracer(__name__)

@app.route("/place-card-hold")
def create_order():
    print("handling place-card-hold request")
    response = requests.get("http://customer-service/get-customer")
    return jsonify({"customer_has_funds": True})

if __name__ == "__main__":
    app.run(host="0.0.0.0", port=80)