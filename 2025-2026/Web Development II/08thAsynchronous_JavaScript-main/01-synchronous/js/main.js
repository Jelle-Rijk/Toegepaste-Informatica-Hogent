const startBtn = document.getElementById('startBtn');
const clickBtn = document.getElementById('clickBtn');

startBtn.onclick = () => {
  console.clear();
  console.log('Started');
  //het duurt 3 sec om onderstaande synchrone code uit te voeren
  const starttime1 = new Date();
  let i = 0;
  while (new Date() - starttime1 < 3000) {
    i++;
  }
  console.log('Ended:', i);
};

let counter = 0;
clickBtn.onclick = () => {
  clickBtn.innerText = ++counter;
};
