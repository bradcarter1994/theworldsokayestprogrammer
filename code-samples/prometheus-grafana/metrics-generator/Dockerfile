FROM python:3.9-slim
WORKDIR /app
COPY requirements.txt .
RUN pip install -r requirements.txt
COPY metrics_generator.py .
CMD ["python", "metrics_generator.py"]