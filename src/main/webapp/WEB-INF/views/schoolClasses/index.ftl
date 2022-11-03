<#include "../template/page.ftl" />
<#include "../template/macro/new-item-buttan.ftl"/>
<#include "../template/macro/list.ftl"/>

<!-- https://www.dariawan.com/tutorials/spring/spring-boot-freemarker-crud-example/ -->
<!-- https://github.com/leszekgruchala/spring-freemarker-crud -->
<!-- https://github.com/alanshaw/pagination-freemarker-macros/blob/master/pagination.ftl -->

<@pageWithContainer title="Tantárgyak">
    <@numberOfItems number=numberOfSchoolClass name="osztály">
    <table class="table table-dark table-striped">
                      <thead>
                          <tr>
                            <th>Azon.</th>
                            <th>Évfolyam</th>
                            <th>Osztály</th>
                            <th>TanárID</th>
                            <th>Szerkesztés</th>
                            <th>Törlés</th>
                          </tr>
                      </thead>
                        <tbody>
                        
                        <#list schoolClasses as schoolClass>
                          <tr>
                              <td><a href="">${schoolClass.id}</a></td>
                              <td>${schoolClass.schoolClass}</td>
                              <td>${schoolClass.classType}</td>
                              <td>${schoolClass.teacherId}</td>
                              <td> <a class="btn btn-primary btn-xs" href="">Szerkesztés</a></td>
                              <td> <a class="btn btn-primary btn-xs" href="">Törlés</a></td>
                          </tr>
                        </#list>
                       
                         </tbody>
                      </table>
    </@numberOfItems>

    <@newItemButtan link="/ftl/schoolClass/signup" name="osztály" />

 </@pageWithContainer>