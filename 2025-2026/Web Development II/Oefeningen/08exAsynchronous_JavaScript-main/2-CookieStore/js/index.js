import * as helpers from "../modules/helpers.js";

function init() {
  const day = 24 * 60 * 60 * 1000;
  const promise = cookieStore.set({
    name: "cookie1",
    value: "cookie1-value",
    expires: Date.now() + day,
  });

  const promise2 = cookieStore.set({
    name: "cookie2",
    value: "cookie2-value",
    expires: Date.now() + day,
  });

  promise.then(() => {
    helpers.addMessage("cookie1 created");
  });

  Promise.all([promise, promise2]).then((p) => {
    helpers.addMessage("cookie1 en cookie2 created");
    document.getElementById("btn1").addEventListener("click", () => {
      cookieStore
        .get("cookie2")
        .then((res) => helpers.addMessage(`waarde van cookie2: ${res.value}`));
    });
    document.getElementById("btn2").addEventListener("click", () => {
      cookieStore
        .getAll()
        .then((res) =>
          res.forEach((c) => helpers.addMessage(`${c.name} = ${c.value}`)),
        );
    });
    document.getElementById("btn3").addEventListener("click", () => {
      helpers.clearMessages();
    });
  });
}

window.onload = init;
