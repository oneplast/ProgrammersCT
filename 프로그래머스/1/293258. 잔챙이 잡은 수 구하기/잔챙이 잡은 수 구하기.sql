select count(*) FISH_COUNT
from FISH_INFO
where LENGTH <= 10.0
or LENGTH is null;