select id,
(
    case
        when e.size_of_colony <= 100 then 'LOW'
        when e.size_of_colony > 100 and e.size_of_colony <= 1000 then 'MEDIUM'
        when e.size_of_colony > 1000 then 'HIGH'
    end
) size
from ecoli_data e
