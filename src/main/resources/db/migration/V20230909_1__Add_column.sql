alter table patient add column active BOOLEAN;
update patient set active = true;
alter table patient alter COLUMN active SET NOT NULL;