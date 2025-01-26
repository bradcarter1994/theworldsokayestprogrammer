from prometheus_client import start_http_server, Counter, Gauge, Histogram, Summary
import random
import time

def random_walk(min_val, max_val, max_step):
    current = min_val + max_val / 2
    while True:
        current += random.randrange(-max_step, max_step)
        if current < min_val:
            current = min_val
        elif current > max_val:
            current = max_val
        yield current

class SystemMetricsEmitter:
    cpu_mock = random_walk(0, 100, 10)
    cpu_gauge = Gauge('cpu_usage_percent', 'CPU usage in percent')
    memory_mock = random_walk(0, 16000000000, 1000000000)
    memory_gauge = Gauge('memory_usage_bytes', 'Memory usage in bytes')
    
    def __init__(self):
        pass

    def emit(self):
        self.cpu_gauge.set(next(self.cpu_mock))
        self.memory_gauge.set(next(self.memory_mock))

def generate_metrics():
    systemMetrics = SystemMetricsEmitter()
    while True:
        print("scrape")
        systemMetrics.emit()
        time.sleep(5)

if __name__ == '__main__':
    print("Starting metrics generator")
    start_http_server(8000)
    generate_metrics()