// == Oefening 01 - Vraag 04 ==

class ComplexObject {
  #title;
  #date;
  #tags;

  constructor(title, date, ...tags) {
    this.#title = title;
    this.#date = date;
    this.#tags = tags;
  }

  get title() {
    return this.#title;
  }
  get date() {
    return this.#date;
  }
  get tags() {
    return this.#tags;
  }
  equals(obj) {
    return (
      obj != null &&
      obj instanceof ComplexObject &&
      obj.title === this.#title &&
      obj.tags.length === this.#tags.length &&
      obj.tags.toString() === this.#tags.toString() &&
      obj.date.toString() === this.#date.toString()
    );
  }

  // TODO Deel A
  toJSON() {
    return { title: this.#title, date: this.#date, tags: this.#tags };
  }
}

const originalObject = new ComplexObject(
  "abc",
  new Date("2032-07-30"),
  "t1",
  "t2",
  99,
);

// TODO Deel B
const storage = window.sessionStorage;
storage.setItem("originalObject", JSON.stringify(originalObject));

// TODO Deel C
const savedData = JSON.parse(storage.getItem("originalObject"));

const duplicateObject = new ComplexObject(
  savedData.title,
  savedData.date,
  ...savedData.tags,
);

// Voorbeelduitvoer
if (originalObject.equals(duplicateObject))
  console.log(`originalObject en duplicateObject zijn gelijk!`);
else console.log(`originalObject en duplicateObject zijn niet gelijk!`);
console.log(originalObject);
console.log(duplicateObject);
