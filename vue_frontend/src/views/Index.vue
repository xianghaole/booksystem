<template>
    <div>
        <el-container style="height: 500px; border: 1px solid #eee">
            <el-aside width="200px" style="background-color: rgb(238, 241, 246)">
                <el-menu router :default-openeds="['0', '1']">
                    <el-submenu   v-for="(item,index) in $router.options.routes" :index="index+''" :key="index">
                        <template slot="title"><i class="el-icon-setting"></i>{{item.name}}</template>
                        <el-menu-item v-for="(item2,index2) in item.children" :index="item2.path" :key="index2"
                            :class="$route.path==item2.path?'is-active':''" v-if="item2.show"
                        > {{item2.name}}</el-menu-item>
                    </el-submenu>
                </el-menu>
            </el-aside>

            <el-container>
                <el-header style="text-align: right; font-size: 12px">
                    <!--<el-dropdown>-->
                        <!--<i class="el-icon-setting" style="margin-right: 15px"></i>-->
                        <!--<el-dropdown-menu slot="dropdown">-->
                            <!--<el-dropdown-item>查看</el-dropdown-item>-->
                            <!--<el-dropdown-item>新增</el-dropdown-item>-->
                            <!--<el-dropdown-item>删除</el-dropdown-item>-->
                        <!--</el-dropdown-menu>-->
                    <!--</el-dropdown>-->
                    <!--<span>王小虎</span>-->
                    <span style="font-size:14px; color:blue;">乐钊图书管理系统</span>
                </el-header>

                <el-main>
                    <router-view></router-view>
                </el-main>
            </el-container>
        </el-container>
    </div>
</template>

<script>
    export default {}

</script>

<style>

</style>
