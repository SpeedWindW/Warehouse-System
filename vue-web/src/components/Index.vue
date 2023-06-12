<template>
  <el-container style="height: 100%; border: 1px solid #eee">
    <el-aside :width="aside_width" style="background-color: rgb(238, 241, 246);height: 100vh; margin-left: -1px;">
      <Aside :iscollapse="iscollapse"></Aside>
    </el-aside>
    
    <el-container style="height: 100%;">
      <el-header style="text-align: right; font-size: 12px;height: 100%;border-bottom: darkgray 1px solid;">
        <Header @docollapse="docollapse" :icon="icon"></Header>
      </el-header>
      
      <el-main style="padding: 5px;height: 100%;">
        <router-view/>
      </el-main>

    </el-container>
  </el-container>
</template>

<script>
import Aside from './Aside.vue';
import Header from './Header.vue';



  export default{
  components: {Aside,Header},
    name:"Index",
    data(){
      return{
        iscollapse:false,
        aside_width:'200px',
        icon:'el-icon-s-fold'
      }
    },
    methods:{
      docollapse(){
        this.iscollapse=!this.iscollapse
        if(!this.iscollapse){//展开
          this.aside_width='200px'
          this.icon='el-icon-s-fold'
        }else{//收起
          this.aside_width='64px'
          this.icon='el-icon-s-unfold'
        }
      }
    }
  }
</script>

<style>
.el-header {
  /* background-color: #B3C0D1; */
  color: #333;
  line-height: 60px;
}
.el-aside {
  color: #333;
}
</style>