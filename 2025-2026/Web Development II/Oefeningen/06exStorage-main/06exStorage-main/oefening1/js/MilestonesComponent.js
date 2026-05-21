import Milestone from "./Milestone.js";
export default class MilestonesComponent {
  #storage;
  #milestones = [];
  constructor(storage) {
    this.#storage = storage;
    this.#getMilestonesFromStorage();

    const addButton = document.getElementById("add");
    const clearButton = document.getElementById("clear");
    const nameText = document.getElementById("name");
    const dateText = document.getElementById("date");

    addButton.onclick = () => {
      try {
        this.#addMilestone(nameText.value, dateText.value);
      } catch (err) {
        alert(err);
      }
    };

    clearButton.onclick = () => {
      if (confirm("Are you sure you want to clear all milestones?"))
        this.#clearMilestones();
    };

    this.#toHTML();
  }

  #addMilestone(name, date) {
    if (!name || !date) throw Error("Name and date are required.");
    const milestone = new Milestone(name, date);
    if (milestone.daysUntilDeadline <= 0)
      throw Error("This milestone is in the past and wasn't added.");
    this.#milestones.push(milestone);
    this.#setMilestonesInStorage();
    this.#toHTML();
  }

  #deleteMilestone(ind) {
    this.#milestones.splice(ind, 1);
    this.#setMilestonesInStorage();
    this.#toHTML();
  }

  #clearMilestones() {
    this.#milestones = [];
    this.#storage.removeItem("milestones");
    this.#toHTML();
  }

  #toHTML() {
    const overview = document.getElementById("overview");
    overview.innerHTML = "";

    this.#milestones.map((m, ind) => {
      const note = document.createElement("div");
      note.setAttribute("class", "notification");

      const btn = document.createElement("button");
      btn.setAttribute("class", "delete");
      btn.addEventListener("click", () => {
        if (
          confirm(
            `You are about to delete milestone ${m.name}. Are you sure you want to do this?`,
          )
        ) {
          this.#deleteMilestone(ind);
        }
      });
      note.appendChild(btn);

      const text = document.createTextNode(
        `${m.daysUntilDeadline} days left until ${m.name}`,
      );
      note.appendChild(text);

      overview.appendChild(note);
    });
  }

  #getMilestonesFromStorage() {
    const data = JSON.parse(this.#storage.getItem("milestones"));
    if (!data) {
      this.#milestones = [];
      return;
    }
    const milestones = [];
    for (let el of data) {
      const m = new Milestone(el.name, el.date);
      if (m.daysUntilDeadline > 0) milestones.push(m);
    }
    this.#milestones = milestones;
  }

  #setMilestonesInStorage() {
    const sortedMilestones = this.#milestones.toSorted(
      (a, b) => b.date - a.date,
    );
    this.#storage.setItem("milestones", JSON.stringify(sortedMilestones));
  }
}
