# Build Angular
FROM node:18 AS build
WORKDIR /usr/src/app
COPY package*.json ./
RUN npm ci
COPY . .
RUN npm run build -- --configuration production

# Serve with nginx
FROM nginx:alpine
RUN rm -rf /usr/share/nginx/html/*

COPY --from=build /usr/src/app/dist/frontend/browser /usr/share/nginx/html/
COPY nginx.conf /etc/nginx/nginx.conf

EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]