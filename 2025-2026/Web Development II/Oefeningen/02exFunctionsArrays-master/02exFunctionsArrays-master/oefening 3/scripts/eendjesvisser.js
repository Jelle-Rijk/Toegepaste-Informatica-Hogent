export function vindBestePositie(eendjes, aantalVangen = 4) {
  let hoogsteScore = 0;
  let hoogsteIndex = 0;
  for (let i = 0; i < eendjes.length - aantalVangen; i++) {
    let score = 0;
    for (let j = i; j < i + aantalVangen; j++) {
      score += eendjes[j];
    }
    if (score > hoogsteScore) {
      hoogsteScore = score;
      hoogsteIndex = i;
    }
  }
  return hoogsteIndex + 1;
}
