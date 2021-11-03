############################
####### develop step #######
############################
FROM node:alpine as develop-step
WORKDIR ./app
COPY package*.json ./
RUN npm install vue-cli -global
COPY . .

###########################
####### build step ########
###########################
FROM develop-step as build-step
RUN npm run build

###########################
##### production step #####
###########################
FROM nginx  as production-step
EXPOSE 8081
COPY ./nginx/default.conf /etc/nginx/conf.d/default.conf
COPY --from=build-step /app/dist/spa /usr/share/nginx/html
