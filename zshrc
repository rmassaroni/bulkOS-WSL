source "/mnt/c/Users/12012/dev/env/rjrc/welcome-message.sh"

# Enable Powerlevel10k instant prompt. Should stay close to the top of ~/.zshrc.
# Initialization code that may require console input (password prompts, [y/n]
# confirmations, etc.) must go above this block; everything else may go below.
if [[ -r "${XDG_CACHE_HOME:-$HOME/.cache}/p10k-instant-prompt-${(%):-%n}.zsh" ]]; then
  source "${XDG_CACHE_HOME:-$HOME/.cache}/p10k-instant-prompt-${(%):-%n}.zsh"
fi

export PATH=$PATH:/snap/bin
export PATH=$PATH:/home/rjm/.local/bin:/home/linuxbrew/.linuxbrew/bin
export PATH=$PATH:/home/linuxbrew/.linuxbrew/bin/brew
#export PATH=$PATH:/snap/bin/nvim
LS_COLORS=$LS_COLORS'ow=1;34:' ; export LS_COLORS


#export CDPATH=/mnt/c/Users/12012/dev



dir="/mnt/c/Users/12012/dev/env/rjscripts"
source "$dir/shortcuts.sh"
dir="/mnt/c/Users/12012/dev/env/rjscripts/gpush"
source "$dir/gconfig.sh"
source "$dir/gcopy.sh"
source "$dir/glink.sh"
source "$dir/gpush.sh"


# Created by Zap installer
[ -f "${XDG_DATA_HOME:-$HOME/.local/share}/zap/zap.zsh" ] && source "${XDG_DATA_HOME:-$HOME/.local/share}/zap/zap.zsh"
plug "romkatv/powerlevel10k"
plug "zsh-users/zsh-autosuggestions"
plug "zap-zsh/supercharge"
plug "zap-zsh/zap-prompt"
plug "zsh-users/zsh-syntax-highlighting"
plug "zap-zsh/completions"

# Load and initialise completion system
autoload -Uz compinit
compinit


# To customize prompt, run `p10k configure` or edit ~/.p10k.zsh.
[[ ! -f ~/.p10k.zsh ]] || source ~/.p10k.zsh

