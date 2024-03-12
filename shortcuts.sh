scripts() {
    cd /mnt/c/Users/12012/projects/scripts
}

c() {
    cd "${1:-"$HOME"}" && ls
}


n() {
    nvim
}

config() {
    cd ~/.config
}

con() {
    config
}

projects() {
    cd /mnt/c/Users/12012/projects
}

p() {
    projects
}

dev() {
    cd /mnt/c/Users/12012/dev
}
