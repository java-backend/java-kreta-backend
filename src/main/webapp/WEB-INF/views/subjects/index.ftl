<#include "../template/page.ftl" />
<#include "../template/macro/new-item-buttan.ftl"/>
<#include "../template/macro/list.ftl"/>
<!-- https://www.dariawan.com/tutorials/spring/spring-boot-freemarker-crud-example/ -->
<!-- https://github.com/leszekgruchala/spring-freemarker-crud -->
<!-- https://github.com/alanshaw/pagination-freemarker-macros/blob/master/pagination.ftl -->
<@pageWithContainer title="Tantárgyak">

  <@numberOfItems number=numberOfSubject name="tantárgy">


                   <table class="table table-dark table-striped">
                      <thead>
                          <tr>
                            <th>Azon.</th>
                            <th>Tantárgy</th>
                            <th>Szerkesztés</th>
                            <th>Törlés</th>
                          </tr>
                      </thead>
                        <tbody>
                        
                        <#list subjects as subject>
                          <tr>
                              <td>${subject.id}</td>
                              <td>${subject.subjectName}</td>
                              <td> <a class="btn btn-primary btn-xs" href="/ftl/subject/edit/${subject.id}">Szerkesztés</a></td>
                              <td> <a class="btn btn-primary btn-xs" href="/ftl/subject/delete/${subject.id}">Törlés</a></td>
                          </tr>
                        </#list>
                       
                         </tbody>
                      </table>
                      
  </@numberOfItems>                  
                      
                    
                      <@newItemButtan link="/ftl/subject/signup" name="tantárgy" />



 </@pageWithContainer>