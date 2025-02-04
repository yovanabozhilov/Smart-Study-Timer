// script.js
let timer;
let isRunning = false;
let seconds = 0;
let minutes = 0;
let interval;
let isPaused = false;
let studyProgress = 0; // Progress for the user (in minutes)

// Function to format time as MM:SS
function formatTime() {
    let sec = seconds % 60;
    let min = Math.floor(seconds / 60);
    return `${min < 10 ? '0' + min : min}:${sec < 10 ? '0' + sec : sec}`;
}

// Start/Stop Timer Function
document.getElementById("startButton").addEventListener("click", () => {
    if (isRunning) {
        clearInterval(interval);
        document.getElementById("startButton").textContent = "Resume Timer";
        isRunning = false;
    } else {
        interval = setInterval(updateTimer, 1000);
        document.getElementById("startButton").textContent = "Pause Timer";
        isRunning = true;
    }
});

// Update Timer every second
function updateTimer() {
    if (isPaused) return; // Do nothing when paused

    seconds++;

    // Automatically pause every 25 minutes
    if (seconds % (25 * 60) === 0) {
        triggerPause();
    }

    document.getElementById("timerDisplay").textContent = formatTime();
}

// Trigger pause after 25 minutes of activity
function triggerPause() {
    clearInterval(interval);
    document.getElementById("status").textContent = "Time for a break!";
    isPaused = true;
    setTimeout(() => {
        isPaused = false;
        document.getElementById("status").textContent = "";
        interval = setInterval(updateTimer, 1000);
    }, 30000); // 30 seconds pause, for example
}

// JavaScript to call backend and save progress (optional)
function saveProgress() {
    fetch('/save-progress', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({ timeSpent: seconds, progress: studyProgress })
    })
        .then(response => response.json())
        .then(data => console.log("Progress saved", data))
        .catch(error => console.error('Error:', error));
}
