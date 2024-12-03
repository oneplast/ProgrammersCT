select distinct r.id id, r.genotype genotype, parent.genotype parent_genotype
from ecoli_data parent
join ecoli_data child on parent.id = child.parent_id
join ecoli_data r on r.parent_id = parent.id
and r.genotype & parent.genotype = parent.genotype
order by id asc;