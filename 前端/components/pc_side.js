var side_template = `
<ul class="nav flex-column" style="margin-bottom:250px;margin-top:30px;background-color:#F5F5F5">
  <li class="nav-item">
    <router-link to="/empsel" v-bind:class="['nav-link',item==1 ? 'text-danger' : 'text-dark']" >用户查询</router-link>
  </li>
  <li class="nav-item">
   <router-link to="/empedit" :class="['nav-link',item==2 ? 'text-danger' : 'text-dark']">用户管理</router-link>
  </li>
  <li class="nav-item">
    <router-link to="/appa" :class="['nav-link',item==3 ? 'text-danger' : 'text-dark']">器材管理</router-link>
  </li> 
  <li class="nav-item">
    <router-link to="/place" :class="['nav-link',item==4 ? 'text-danger' : 'text-dark']">场地管理</router-link>
  </li> 
  <li class="nav-item">
    <router-link to="/cocah" :class="['nav-link',item==5 ? 'text-danger' : 'text-dark']">教练管理</router-link>
  </li>
  <li class="nav-item">
    <router-link to="/course" :class="['nav-link',item==6 ? 'text-danger' : 'text-dark']">课程管理</router-link>
  </li>  
  <li class="nav-item">
  <router-link to="/user" :class="['nav-link',item==7 ? 'text-danger' : 'text-dark']">登录管理</router-link>
</li> 
</ul>
  `
Vue.component('side', {
  props: {
    item : String,
  },
  data: function () {
    return {
    }
  },
  template: side_template,
});
