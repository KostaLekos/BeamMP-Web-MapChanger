FROM node:20-alpine

# Install bash and Java 21
RUN apk add --no-cache bash openjdk25

WORKDIR /app

COPY html /app/html
COPY backend /app/backend

EXPOSE 30202

CMD ["node", "backend/node.js"]

