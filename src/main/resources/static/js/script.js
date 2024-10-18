console.log("Script loaded");

// Initialize the current theme from localStorage or default to 'light'
let activeTheme = getTheme();

document.addEventListener("DOMContentLoaded", () => {
    initializeTheme();
  });

function initializeTheme() {
  changePageTheme(activeTheme);

  const changeThemeButton = document.querySelector("#theme_change_button");
  // Add listener for the theme change button
  changeThemeButton.addEventListener("click", toggleTheme);
}

//TODO
function toggleTheme() {
    const previousTheme = activeTheme;
    activeTheme = activeTheme === "dark" ? "light" : "dark";
  
    //console.log(`Theme changed from ${previousTheme} to ${activeTheme}`);
    changePageTheme(activeTheme, previousTheme);
  }

function setTheme(theme) {
  localStorage.setItem("theme", theme);
}

function getTheme() {
  return localStorage.getItem("theme") || "light";
}

function changePageTheme(newTheme, oldTheme = "") {
  setTheme(newTheme); // Update localStorage

  const htmlElement = document.querySelector("html");

  if (oldTheme) {
    htmlElement.classList.remove(oldTheme);
  }
  htmlElement.classList.add(newTheme);

  // Update the button text to reflect the opposite of the current theme
  const changeThemeButton = document.querySelector("#theme_change_button span");
  changeThemeButton.textContent = newTheme === "light" ? "Dark" : "Light";
}
