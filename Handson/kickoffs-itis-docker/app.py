from flask import Flask

app = Flask(__name__)

@app.route('/')
def index():
    return '<h2>Flask application has been successfully deployed using Docker.</h2>'
