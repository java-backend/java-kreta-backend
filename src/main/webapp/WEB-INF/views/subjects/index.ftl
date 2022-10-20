<#include "../template/page.ftl" />
<#include "../template/macro/new-item-buttan.ftl"/>
<#include "../template/macro/list.ftl"/>
<!-- https://www.dariawan.com/tutorials/spring/spring-boot-freemarker-crud-example/ -->
<!-- https://github.com/leszekgruchala/spring-freemarker-crud -->
<!-- https://github.com/alanshaw/pagination-freemarker-macros/blob/master/pagination.ftl -->
<@pageWithContainer title="Tantárgyak">

  <@numberOfItems number=numberOfItems name="tantárgy">


                   <table class="table table-dark table-striped">
                      <thead>
                          <tr>
                            <th>Azon.</th>
                            <th>Tantárgy</th>
                            <th>Szerkesztés</th>
                            <th>Törlés</th>
                          </tr>
                      </thead>
                        <#list subjects as subject>
                        <tr>
                            <td>${subject.id}</td>
                            <td>${subject.name}</td>
                        </tr>
                        </#list>

                      </table>
                      
  </@numberOfItems>                    
                      
                    
                      <@newItemButtan link="awdw" name="tantárgy" />



 </@pageWithContainer>