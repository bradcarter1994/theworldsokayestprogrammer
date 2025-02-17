from prometheus_client import start_http_server, Counter, Gauge, Histogram, Summary
import random
import signal
import sys
import time

def sigterm_handler(signum, frame):
    sys.exit(0)

signal.signal(signal.SIGTERM, sigterm_handler)

def random_walk(min_val, max_val, max_step):
    current = min_val + max_val / 2
    while True:
        current += random.randrange(-max_step, max_step)
        if current < min_val:
            current = min_val
        elif current > max_val:
            current = max_val
        yield current

def random_observations(min_observations, max_observations, min_observation_value, max_observation_value):
    num_observations = random.randint(min_observations, max_observations)
    observations = [random.randint(min_observation_value, max_observation_value) for _ in range(num_observations)]
    return observations

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

class RequestMetricsEmitter:
    request_counter = Counter('request_counter', 'Request counter')
    request_latency_ms = Histogram('request_latency', 'Request latency', buckets=(5, 10, 50, 100, 500, 1000, 5000, 10000, 50000, 100000, 500000, 1000000, float("inf")))

    def __init__(self):
        pass

    def emit(self):
        observations = random_observations(50, 100, 1, 100000)
        self.request_counter.inc(len(observations))
        for observation in observations:
            self.request_latency_ms.observe(observation)

def generate_metrics():
    systemMetrics = SystemMetricsEmitter()
    requestMetrics = RequestMetricsEmitter()
    while True:
        print("scrape")
        systemMetrics.emit()
        requestMetrics.emit()
        time.sleep(5)

if __name__ == '__main__':
    print("Starting metrics generator")
    start_http_server(8000)
    generate_metrics()