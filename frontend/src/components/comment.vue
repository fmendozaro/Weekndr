<template>
    <div class="comment-tree">
        <div :style="indent">
            <div><span style="color:#89B6BE; font-weight: bold; position: absolute">{{username}}:</span></div>
            {{label}}
            <v-btn color="#E96445" flat :ripple="false" icon @click="parent(id)">
                <i class="far fa-comment 10x"></i>
            </v-btn>
            <comment v-if="comments[index] != undefined"  v-for="(comment, index) in comments" :key="index" :comments="comment.childComments" :label="comment.comment" :id="comment.id" :username="comment.user.username" :depth="depth + 1">
            </comment>
        </div>
    </div>
</template>

<script>
    import store from '../store'
    export default {
        name: "comment",
        props: [ 'label', 'comments', 'depth', 'id', 'username' ],
        computed: {
            indent() {
                return { transform: `translate(${this.depth * 25}px)` }
            }
        },
        methods:{

            //gets parent id and commits it to store so comment can be registered in the right order
            parent(id){
                store.commit('changeParentComment',id);
            }
        }
    }
</script>

<style scoped>

</style>