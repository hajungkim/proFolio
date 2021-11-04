# ./Dockerfile
FROM python:3
WORKDIR /usr/src/app

COPY requirements.txt ./

## Install packages
RUN pip install --upgrade pip

RUN pip install -U pip wheel cmake
RUN pip install -r requirements.txt

## Copy all src files
COPY . .

## Run the application on the port 8080
EXPOSE 8000

CMD ["python", "manage.py", "runserver", "0.0.0.0:8000"]
