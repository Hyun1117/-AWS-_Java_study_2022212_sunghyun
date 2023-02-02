create index product_id on product_mst(product_code);

show index from product_mst;

alter table product_mst
add unique product_name(product_name);

alter table product_mst
drop index product_id;

