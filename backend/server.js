const http = require("http");
const { exec } = require("child_process");

const JAVA_DIR = "/srv/data/appdata/beam-map/html";
const JAVA_CMD = "java Choice";

http.createServer((req, res) => {
  if (req.method === "POST" && req.url.startsWith("/run")) {

    const param = "test123";

    exec(`${JAVA_CMD} ${param}`, { cwd: JAVA_DIR }, (err, stdout, stderr) => {
      if (err) {
        res.writeHead(500);
        res.end(stderr || err.message);
        return;
      }
      res.end(stdout || "No output from Java");
    });

  } else {
    res.writeHead(404);
    res.end("no");
  }
}).listen(30202, "127.0.0.1");

console.log("Node server running on 127.0.0.1:30202");

