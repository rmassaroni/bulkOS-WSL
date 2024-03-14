" Title:        Example Plugin
" Description:  A plugin to provide an example for creating Neovim plugins.
" Last Change:  8 November 2021
" Maintainer:   Example User <https://github.com/example-user>

" Prevents the plugin from being loaded multiple times. If the loaded
" variable exists, do nothing more. Otherwise, assign the loaded
" variable and continue running this instance of the plugin.
if exists("g:loaded_nvim_4mat")
    finish
endif
let g:loaded_nvim_4mat = 1

" Defines a package path for Lua. This facilitates importing the
" Lua modules from the plugin's dependency directory.
let s:lua_rocks_deps_loc =  expand("<sfile>:h:r") . "/../lua/nvim-4mat/deps"
""let s:module_path = s:lua_rocks_deps_loc . "/lua-ljsqlite3.lua"
exe "lua package.path = package.path .. ';" . s:lua_rocks_deps_loc . "/lua-?/init.lua'"
""exe "lua package.path = package.path .. ';" . s:module_path . "'"

""exe "lua print(s:lua_rocks_deps_loc)"

" Exposes the plugin's functions for use as commands in Neovim.
command! -nargs=0 FetchTodos lua require("nvim-4mat").fetch_todos()
command! -nargs=0 InsertTodo lua require("nvim-4mat").insert_todo()
command! -nargs=0 CompleteTodo lua require("nvim-4mat").complete_todo()
