from opentelemetry import trace
from opentelemetry.sdk.trace import TracerProvider
from opentelemetry.sdk.trace.export import BatchSpanProcessor
from opentelemetry.exporter.otlp.proto.grpc.trace_exporter import OTLPSpanExporter
from opentelemetry.instrumentation.requests import RequestsInstrumentor
from opentelemetry.sdk.resources import Resource
import requests
import signal
import sys
import time

# Initialize instrumentors
resource = Resource.create({"service.name": "front-end"})
trace.set_tracer_provider(TracerProvider(resource=resource))
otlp_exporter = OTLPSpanExporter(endpoint="http://jaeger:4317")
span_processor = BatchSpanProcessor(otlp_exporter)
trace.get_tracer_provider().add_span_processor(span_processor)
RequestsInstrumentor().instrument()
tracer = trace.get_tracer(__name__)

def generate_metrics():
    while True:
        print("calling order service")
        response = requests.get("http://order-service/")
        print(response)
        time.sleep(5)

def sigterm_handler(signum, frame):
    sys.exit(0)

signal.signal(signal.SIGTERM, sigterm_handler)

if __name__ == '__main__':
    print("Starting request generator")
    generate_metrics()