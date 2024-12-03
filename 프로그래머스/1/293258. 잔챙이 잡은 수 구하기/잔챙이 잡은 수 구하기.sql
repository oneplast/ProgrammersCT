select count(*) FISH_COUNT
from FISH_INFO
where IFNULL(LENGTH, 0) < 10