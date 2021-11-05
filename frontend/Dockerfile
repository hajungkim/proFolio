#build stage
FROM node:12.2.0-alpine  as build-stage
WORKDIR /app
COPY package*.json ./
COPY . .
RUN yarn global add @vue/cli
RUN yarn remove node-sass
RUN yarn add node-sass@4.14.1
RUN yarn run build

#production stage
FROM nginx
EXPOSE 8081
COPY ./nginx/default.conf /etc/nginx/conf.d/default.conf
COPY --from=build-stage /app/dist /usr/share/nginx/html
