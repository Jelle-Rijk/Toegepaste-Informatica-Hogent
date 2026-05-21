import Trivia from "./trivia.js";

export default class TriviaRepository {
  #trivias = [];
  #answers = [];

  get trivias() {
    return this.#trivias;
  }

  get numberOfTrivias() {
    return this.#trivias.length;
  }

  get numberOfAnswers() {
    return this.#answers.length;
  }

  // geeft de volgende trivia terug (werkt op basis van
  // het aantal reeds gegeven antwoorden).
  get trivia() {
    return this.#trivias[this.#answers.length];
  }

  get correctAnswers() {
    return this.#answers.filter((ans) => ans).length;
  }

  addTrivias(dataObjects) {
    for (const obj of dataObjects) {
      const answers = [obj["correct_answer"], ...obj["incorrect_answers"]];
      const trivia = new Trivia(
        obj["category"],
        obj["difficulty"],
        obj["question"],
        answers,
        obj["correct_answer"],
      );
      this.#trivias.push(trivia);
    }
  }

  checkAnswer(answer) {
    const correct = this.trivia.correctAnswer === answer;
    this.#answers.push(correct);
    return correct;
  }

  checkEndGame() {
    return this.#trivias.length === this.#answers.length;
  }
}
