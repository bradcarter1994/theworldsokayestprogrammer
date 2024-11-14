from prometheus_client import start_http_server, Gauge
import random
import time

# Create metrics
cpu_usage = Gauge('cpu_usage_percent', 'CPU usage in percent')
memory_usage = Gauge('memory_usage_bytes', 'Memory usage in bytes')

def generate_metrics():
    while True:
        cpu_usage.set(random.uniform(0, 100))
        memory_usage.set(random.uniform(0, 16000000000))
        time.sleep(5)

if __name__ == '__main__':
    start_http_server(8000)
    generate_metrics()