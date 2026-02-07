const http = require("http");
const { spawn } = require("child_process");

const JAVA_DIR = "/app/backend"; // inside container
const JAVA_CMD = "java";

http.createServer((req, res) => {
  if (req.method === "POST" && req.url === "/run") {

    let body = "";
    req.on("data", chunk => body += chunk);
    req.on("end", () => {
      const param = body.trim();
      if (!param) {
        res.writeHead(400);
        return res.end("Missing parameter");
      }

      const child = spawn(JAVA_CMD, ["Choice", param], { cwd: JAVA_DIR });

      let output = "";
      child.stdout.on("data", data => output += data.toString());
      child.stderr.on("data", data => output += data.toString());

      child.on("close", () => res.end(output || "OK"));
    });

  } else {
    res.writeHead(404);
    res.end("Not found");
  }
}).listen(30202, "0.0.0.0");

console.log("Node server running on :30202");

