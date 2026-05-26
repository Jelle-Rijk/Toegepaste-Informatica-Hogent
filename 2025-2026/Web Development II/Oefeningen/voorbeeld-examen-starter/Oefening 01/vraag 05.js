// == Oefening 01 - Vraag 05 ==

const songs = [
  {
    title: "Love that music",
    duration: 265,
    genres: ["pop", "world", "jazz"],
  },
  { title: "Breathing music", duration: 302, genres: [] },
  { title: "Life is music", duration: 274, genres: ["r&b"] },
  { title: "M for music", duration: 204, genres: ["r&b"] },
  { title: "Music from Mars", duration: 242, genres: ["rock", "metal"] },
];

// TODO Deel A
const shortSongs = songs.filter((song) => song.duration < 250);

// Voorbeelduitvoer
console.log(shortSongs);

// TODO Deel B
const sortedSongs = songs.toSorted((song1, song2) => {
  if (song1.genres.length === song2.genres.length) {
    return song1.title < song2.title ? -1 : 1;
  }
  return song1.genres.length - song2.genres.length;
});

// Voorbeelduitvoer
console.log(sortedSongs);
