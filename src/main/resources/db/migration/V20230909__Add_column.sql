alter table doctor add column active BOOLEAN;
update doctor set active = true;
alter table doctor alter COLUMN active SET NOT NULL;