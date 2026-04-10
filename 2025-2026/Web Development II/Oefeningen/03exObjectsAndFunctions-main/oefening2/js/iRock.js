const rockImg = document.getElementById("rockImg");
let clickCounter = 0;

const myPetRock = {
  username: "",
  image: "images/rock.png",
};

export function greetUser() {
  alert("Hello, I am your pet rock.");
  rockImg.addEventListener("click", touchRock);
}

function touchRock() {
  clickCounter++;
  if (myPetRock.username === "")
    myPetRock.username = prompt("What is your name?");
  else
    alert(
      `I like the attention, ${myPetRock.username}. Thank you.\nYou already clicked on me ${clickCounter} times.`,
    );
  myPetRock.image = "images/rock_happy.png";
  showRock();
  myPetRock.image = "images/rock.png";
  setTimeout(showRock, 2 * 1000);
}

function showRock() {
  rockImg.setAttribute("src", myPetRock.image);
}
