select count(*) fish_count
from fish_name_info fn
join fish_info fi on fi.fish_type = fn.fish_type
and fn.fish_name in ('BASS', 'SNAPPER');