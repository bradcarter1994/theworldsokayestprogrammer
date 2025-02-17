import requests
import signal
import sys
import time

def generate_metrics():
    while True:
        print("calling order service")
        response = requests.get("http://order-service:5000/")
        print(response)
        time.sleep(5)

def sigterm_handler(signum, frame):
    sys.exit(0)

signal.signal(signal.SIGTERM, sigterm_handler)

if __name__ == '__main__':
    print("Starting request generator")
    generate_metrics()