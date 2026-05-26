// == Oefening 01 - Vraag 01 ==

const names = ["Jude", "Jude", "Lana", "Drew", "Jude", "Jude", "Jude", "Lana"];

// TODO Deel A
function addName(allNames, newName) {
  const name =
    newName.substring(0, 1).toUpperCase() + newName.substring(1).toLowerCase();
  allNames.push(name);
}

// Voorbeeld
addName(names, "aNnIe");
addName(names, "EliSA");
console.log(names);

// TODO Deel B
function isPopularName(name, allNames, popularityLevel = 1) {
  return allNames.filter((n) => n === name).length > popularityLevel;
}

// Voorbeeld
console.log(
  "isPopularName('Jude', names, 3) -> " + isPopularName("Jude", names, 3),
);
console.log(
  "isPopularName('Jude', names, 5) -> " + isPopularName("Jude", names, 5),
);
console.log("isPopularName('Lana', names) -> " + isPopularName("Lana", names));
console.log("isPopularName('Drew', names) -> " + isPopularName("Drew", names));
console.log(
  "isPopularName('Drew', names, 0) -> " + isPopularName("Drew", names, 0),
);

// TODO Deel C
function giveNamesWithoutRepetition(allNames) {
  for (let i = 0; i < allNames.length - 1; i++) {
    if (allNames[i] === allNames[i + 1]) allNames.splice(i, 1);
  }
  return allNames;
}

// Voorbeeld
console.log(
  giveNamesWithoutRepetition([
    "Jude",
    "Jude",
    "Lana",
    "Drew",
    "Drew",
    "Jude",
    "Jude",
    "Jude",
    "Lana",
  ]),
);
