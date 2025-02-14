<template>
  <div class="search-container">
    <el-input
        v-model="searchQuery"
        placeholder="搜索商品..."
        class="search-input"
        @keyup.enter="handleSearch"
        clearable
    >
      <template #prefix>
        <el-icon>
          <Search/>
        </el-icon>
      </template>
      <template #append>
        <el-button @click="handleSearch">搜索</el-button>
      </template>
    </el-input>

    <div class="search-suggestions" v-if="showSuggestions && suggestions.length">
      <ul class="suggestions-list">
        <li
            v-for="item in suggestions"
            :key="item.id"
            class="suggestion-item"
            @click="selectSuggestion(item)"
        >
          <el-icon>
            <Goods/>
          </el-icon>
          <span>{{ item.name }}</span>
          <span class="suggestion-price">¥{{ item.price }}</span>
        </li>
      </ul>
    </div>

    <div class="search-tags">
      <span>热门搜索：</span>
      <el-tag
          v-for="tag in hotTags"
          :key="tag"
          class="hot-tag"
          @click="searchByTag(tag)"
      >
        {{ tag }}
      </el-tag>
    </div>
  </div>
</template>

<script>
import {ref, watch} from 'vue'
import {Search, Goods} from '@element-plus/icons-vue'
import {debounce} from 'lodash'

export default {
  name: 'SearchBar',
  components: {
    Search,
    Goods
  },
  setup(props, {emit}) {
    const searchQuery = ref('')
    const showSuggestions = ref(false)
    const suggestions = ref([])
    const hotTags = ref(['手机', '电脑', '服装', '食品'])

    // 防抖处理搜索建议
    const fetchSuggestions = debounce(async (query) => {
      if (query.length < 2) {
        suggestions.value = []
        showSuggestions.value = false
        return
      }

      // 模拟API调用
      suggestions.value = [
        {id: 1, name: '商品1', price: '99.99'},
        {id: 2, name: '商品2', price: '199.99'},
      ]
      showSuggestions.value = true
    }, 300)

    watch(searchQuery, (newValue) => {
      fetchSuggestions(newValue)
    })

    const handleSearch = () => {
      if (!searchQuery.value) return
      emit('search', searchQuery.value)
      showSuggestions.value = false
    }

    const selectSuggestion = (item) => {
      searchQuery.value = item.name
      handleSearch()
    }

    const searchByTag = (tag) => {
      searchQuery.value = tag
      handleSearch()
    }

    return {
      searchQuery,
      showSuggestions,
      suggestions,
      hotTags,
      handleSearch,
      selectSuggestion,
      searchByTag
    }
  }
}
</script>

<style scoped>
.search-container {
  position: relative;
  width: 100%;
  max-width: 600px;
  margin: 0 auto;
}

.search-input {
  width: 100%;
}

.search-suggestions {
  position: absolute;
  top: 100%;
  left: 0;
  right: 0;
  background: white;
  border: 1px solid #dcdfe6;
  border-radius: 4px;
  margin-top: 4px;
  box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);
  z-index: 100;
}

.suggestions-list {
  list-style: none;
  padding: 0;
  margin: 0;
}

.suggestion-item {
  padding: 8px 12px;
  display: flex;
  align-items: center;
  gap: 8px;
  cursor: pointer;
}

.suggestion-item:hover {
  background-color: #f5f7fa;
}

.suggestion-price {
  margin-left: auto;
  color: #ff6b6b;
}

.search-tags {
  margin-top: 8px;
  display: flex;
  align-items: center;
  gap: 8px;
  font-size: 14px;
  color: #606266;
}

.hot-tag {
  cursor: pointer;
  transition: all 0.3s;
}

.hot-tag:hover {
  background-color: #409EFF;
  color: white;
}
</style>